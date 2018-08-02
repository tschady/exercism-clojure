(ns run-length-encoding)

(defn- parse-length-mult
  "Change string representation of run length into integer.
  Empty strings represent one repeat."
  [s]
  (if (empty? s)
    1
    (Integer/parseInt s)))

(defn run-length-encode
  "Compress data by replacing repeat digits with a count of consecutive appearances,
  followed by the digit.  e.g. 'xAAAx' -> 'x3Ax'"
  [s]
  (->> s
       (partition-by identity)
       (map #(str (when-not (= 1 (count %)) (count %)) (first %)))
       (apply str)))

(defn run-length-decode
  "Uncompress data by transforming counts of consecutive characters into exploded
  version.  e.g. 'x2Ai3B4C' -> 'xAAiBBBCCCC'"
  [s]
  (->> s
     (re-seq #"(\d*)([a-zA-Z\s])")
     (map #(update % 1 parse-length-mult))
     (map #(repeat (second %) (last %)))
     (reduce concat)
     (apply str)))
