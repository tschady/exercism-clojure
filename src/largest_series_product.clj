(ns largest-series-product
  (:require [clojure.spec.alpha :as s]))

(s/def ::digit-string (s/and string? #(re-matches #"^[0-9]*$" %)))

(defn largest-product
  "Given a string of digits `s`, calculate the largest product
  for a contiguous substring of digits of length `n`.
  Exception thrown for non-digit chars in string,
  or having `n` exceed the length of `s`."
  [n s]
  {:pre [(or (and (s/valid? ::digit-string s)
                  (<= n (count s)))
             (throw (Exception.)))]}
  (if (and (empty? s) (zero? n))
    1
    (->> s
         (map #(Character/getNumericValue %))
         (partition n 1)
         (map #(reduce * %))
         (apply max))))
