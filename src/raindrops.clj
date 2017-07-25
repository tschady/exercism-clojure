(ns raindrops)

(def dict [[3 "Pling"] [5 "Plang"] [7 "Plong"]])

(defn convert [n]
  (if-let [word-subst (seq (keep (fn [[k v]] (when (zero? (rem n k)) v)) dict))]
    (apply str word-subst)
    (str n)))
