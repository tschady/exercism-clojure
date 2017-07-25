(ns triangle)

(defn- valid-triangle? [a b c]
  (and (< a (+ b c))
       (< b (+ a c))
       (< c (+ a b))))

(defn type [a b c]
  (let [num-uniq-sides (count (set [a b c]))]
    (if (valid-triangle? a b c)
      ([nil :equilateral :isosceles :scalene] num-uniq-sides)
      :illogical)))
