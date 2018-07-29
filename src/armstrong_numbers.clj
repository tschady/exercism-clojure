(ns armstrong-numbers)

(defn armstrong?
  "Predicate to determine if number is an Armstrong number, having the
  property that it is equal to the sum of its own digits raised to the
  power of its digit count."
  [n]
  (let [exploded-digits (map #(Character/digit % 10) (str n))
        digit-count (count exploded-digits)]
    (== n (reduce + (map #(Math/pow % digit-count) exploded-digits)))))
