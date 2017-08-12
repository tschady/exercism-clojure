(ns sum-of-multiples)

(defn sum-of-multiples
  "Given a number `limit`, find the sum of all the multiples of
  particular numbers given by the sequence `mult-xs` up to but
  not including `limit`."
  [mult-xs limit]
  (->> mult-xs
       (mapcat #(range % limit %))
       set
       (reduce +)))
