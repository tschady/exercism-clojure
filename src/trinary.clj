(ns trinary
  (:require all-your-base))

(defn to-decimal
  "Convert a trinary number, represented as string `s`, to a decimal.
  Invalid strings return value 0."
  [s]
  (if (all-your-base/valid-digits? 3 (all-your-base/digit-seq s))
    (all-your-base/to-decimal 3 (all-your-base/digit-seq s))
    0))
