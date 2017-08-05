(ns binary-search)

(defn middle
  "Return index of central element in input vector.
  Rounds up in case of even length input.
  Returns 0 in case of empty input collection."
  [coll]
  (quot (count coll) 2))

(defn search-for
  "Return index of `x` in given vector.
  Throws exception \"not found\" if element does not exist in input."
  [x coll]
  (loop [coll (vec coll)
         offset-idx 0]
    (let [pivot-idx (middle coll)
          pivot-val (get coll pivot-idx)
          curr-idx (+ offset-idx pivot-idx)]
      (cond
        (nil? pivot-val) (throw (Exception. "not found"))
        (= x pivot-val) curr-idx
        (< x pivot-val) (recur (subvec coll 0 pivot-idx) offset-idx)
        (> x pivot-val) (recur (subvec coll (inc pivot-idx)) (inc curr-idx))))))
