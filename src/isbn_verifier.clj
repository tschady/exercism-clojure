(ns isbn-verifier
  (:require [clojure.spec.alpha :as s]
            [clojure.string :as str]))

(def ^:private char->val {\0 0, \1 1, \2 2, \3 3, \4 4, \5 5,
                          \6 6, \7 7, \8 8, \9 9, \X 10})

(defn- strip-dashes [s] (str/replace s #"-" ""))

(defn- isbn-10-checksum [s]
  (let [luhn-sum (->> (keep char->val s)
                      (map * (iterate dec 10))
                      (reduce + 0))]
    (mod luhn-sum 11)))

(s/def ::isbn-10 (s/and string?
                        #(re-matches #"\d{9}[\d|X]" (strip-dashes %))
                        #(zero? (isbn-10-checksum %))))

(defn isbn? [s] (s/valid? ::isbn-10 s))
