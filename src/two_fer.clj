(ns two-fer)

(defn two-fer
  "Output 'One for <s>, one for me.' with default name 'you'."
  ([] (two-fer "you"))
  ([s] (format "One for %s, one for me." s)))
