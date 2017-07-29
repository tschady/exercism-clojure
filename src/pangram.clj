(ns pangram
  (:require [clojure.string :as str]))

(def alphabet (set (map char (range (int \a) (inc (int \z))))))

(defn pangram?
  "Determine if input string is a pangram - a sentence using
  every letter of the English alphabet at least once."
  [s]
  (-> s
      str/lower-case
      set
      (every? alphabet)))
