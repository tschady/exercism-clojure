(ns all-your-base)

(defn valid-digits?
  "Returns true if every digit in sequence `digits` is found in radix `base`,
  else false."
  [base digits]
  (let [digit-range (set (range base))]
    (every? digit-range digits)))

(defn to-decimal
  "Convert a digit sequence from radix `base` to a decimal number."
  [base digits]
  (reduce (fn [a b] (+ (* base a) b)) 0 digits))

(defn- from-decimal
  "Convert a decimal number to a number represented by a sequence of digits
  in new radix `base`."
  [base n]
  (loop [n n
         acc '()]
    (let [digit (mod n base)
          quotient (quot n base)
          acc (conj acc digit)]
      (if (zero? quotient)
        acc
        (recur quotient acc)))))

(defn convert
  "Convert a number, represented as a sequence of `digits` in radix `base-in`,
  to another radix `base-out`.
  Return nil if invalid inputs:  bases less than 2, or digits out of range"
  [base-in digits base-out]
  (cond
    ;; this could all be done with clojure 'when' to return implicit nil,
    ;; but I prefer the explicitness of the 'cond' showing the edge cases
    (< base-in 2) nil
    (< base-out 2) nil
    (empty? digits) '()
    (not (valid-digits? base-in digits)) nil
    :else (->> digits
               (to-decimal base-in)
               (from-decimal base-out))))
