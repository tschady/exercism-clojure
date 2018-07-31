(ns series)

(defn slices
  "Given a string of digits `s`, output all the contiguous substrings
  of length `n` in that string in the order that they appear."
  [s n]
  (if (zero? n)
    [""]
    (map #(apply str %) (partition n 1 s))))
