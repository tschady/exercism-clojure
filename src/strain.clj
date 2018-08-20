(ns strain)

(defn retain
  "Long-form of filter."
  [pred [x1 & xn :as coll]]
  (cond
    (empty? coll) '()
    (pred x1) (cons x1 (retain pred xn))
    :else (retain pred xn)))

(defn discard
  "Long-form of remove."
  [pred coll]
  (retain (complement pred) coll))
