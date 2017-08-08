(ns trinary
  (:require all-your-base))

(defn- digit-seq
  "Convert string into sequence of numeric digits."
  [s]
  (map #(Character/getNumericValue %) s))

(defn to-decimal
  "Convert a trinary number, represented as string `s`, to a decimal.
  Invalid strings return value 0."
  [s]
  (if (all-your-base/valid-digits? 3 (digit-seq s))
    (all-your-base/to-decimal 3 (digit-seq s))
    0))
