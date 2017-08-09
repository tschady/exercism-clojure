(ns perfect-numbers)

(defn- aliquot-sum
  "Return the aliquot sum of a given number `n`, which is defined as the
  sum of the factors of the number excluding the number itself.
  Ex: aliquot sum of 15 is (1 + 3 + 5) = 9"
  [n]
  (->> (range 1 n)
       (filter #(zero? (mod n %)))
       (reduce +)))

(defn classify
  "Return keyword representing Nicomachus' natural number classification for
  given number `n`, based on their aliquot sum.
  Results:
    :perfect  For numbers with aliquot sums equal to themselves
    :abundant For numbers less than their aliquot sum
    :deficient For numbers greater than their aliquot sum"
  [n]
  {:pre [(or (not (neg? n))
             (throw (IllegalArgumentException.)))]}
  (let [a-sum (aliquot-sum n)]
    (cond
      (= n a-sum) :perfect
      (< n a-sum) :abundant
      (> n a-sum) :deficient)))
