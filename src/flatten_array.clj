(ns flatten-array)

(defn flatten [s]
  (remove nil? (clojure.core/flatten s)))
