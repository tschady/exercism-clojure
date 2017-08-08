(ns sublist)

(defn- sublist?
  "Returns true if v1 is a subvector of v2 or equal to v2, else false."
  [v1 v2]
  (let [candidates (partition (count v1) 1 v2)]
    (some #(= v1 %) candidates)))

(defn classify
  "Return keyword representing set relation between input vectors `v1` and `v2`:
  `:equal`      if vectors are equal
  `:sublist`    if `v1` is a proper subvector of `v2`
  `:superlist`  if `v1` is a proper supervector of `v2`
  `:unequal`    all other cases."
  [v1 v2]
  (cond
    (= v1 v2)
    :equal

    (and (< (count v1) (count v2))
         (sublist? v1 v2))
    :sublist

    (and (< (count v2) (count v1))
         (sublist? v2 v1))
    :superlist

    :else
    :unequal))
