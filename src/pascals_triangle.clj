(ns pascals-triangle)

(defn- make-row
  "Generate the next row of Pascal's triangle, given previous row."
  [row]
  (let [shift-right (into [0] row)
        shift-left (conj row 0)]
    (mapv +' shift-right shift-left)))

(def triangle (iterate make-row [1]))

(defn row
  "Return nth row of Pascal's Triangle, using one-based indexing."
  [n]
  (nth triangle (dec n)))
