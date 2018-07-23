(ns luhn
  (:require [clojure.spec.alpha :as s]
            [clojure.string :as str]))

(def luhn-double
  "Luhn 'doubling' results: doubling the digit, subtracting 9 if > 10"
  {0 0, 1 2, 2 4, 3 6, 4 8, 5 1, 6 3, 7 5, 8 7, 9 9})

(defn- strip-spaces [s] (str/replace s #"\s" ""))

(defn- luhn-sum
  "Calculate the luhn sum of an input string of digits with optional
  whitespace.  After normalization, the algorithm 'luhn doubles'
  every second digit from the right, and sums the result."
  [s]
  (->> (strip-spaces s)
       (str/reverse)
       (map #(Character/getNumericValue %))
       (map-indexed (fn [idx digit] (if (odd? idx)
                                      (luhn-double digit)
                                      digit)))
       (reduce +)))

(s/def ::luhn (s/and string?
                     #(re-matches #"[0-9\s]+" %)
                     #(< 1 (count (strip-spaces %)))
                     #(zero? (rem (luhn-sum %) 10))))
