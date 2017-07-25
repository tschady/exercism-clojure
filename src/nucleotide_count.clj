(ns nucleotide-count)

(def dna #{\A \C \T \G})

(defn count [c s]
  {:pre [(or (dna c)
             (throw (Exception. "invalid nucleotide")))]}
  (clojure.core/count (re-seq (re-pattern (str c)) s)))

(defn nucleotide-counts [s]
  (merge (zipmap dna (repeat 0)) (frequencies s)))
