(ns binary-search-tree
  (:require [clojure.zip :as zip]))

;; we could easily use a map (or a vector), just playing with records
(defrecord Node [val l r])

(defn singleton [n] (->Node n nil nil))
(defn value [loc] (:val loc))
(defn left [loc] (:l loc))
(defn right [loc] (:r loc))

(defn insert
  "Add the value `n` to the tree or node specified by `loc`"
  [n loc]
  (cond
    (nil? loc) (singleton n)
    (>= (:val loc) n) (update loc :l #(insert n %))
    :else             (update loc :r #(insert n %))))

(defn to-list
  "Return list of elements in tree `loc` in increasing order"
  [loc]
  (when-not (nil? loc)
    (concat (to-list (:l loc))
            [(:val loc)]
            (to-list (:r loc)))))

(defn from-list
  "Create binary tree structure from unordered input collection `xs`"
  [xs]
  (reduce #(insert %2 %1) nil xs))
