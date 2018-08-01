(ns collatz-conjecture)

(defn collatz
  "Take any positive integer n.  If n is even, divide n by 2 to get n / 2.
  If n is odd, multiply n by 3 and add 1 to get 3n + 1.
  Repeat the process indefinitely, which should always resolve to 1.
  Given a number `n`, return the number of steps required to reach 1."
  [n]
  {:pre [(pos? n)]}
  (loop [turns 0
         x n]
    (cond
      (= 1 x) turns
      (even? x) (recur (inc turns) (/ x 2))
      (odd? x)  (recur (inc turns) (inc (* 3 x))))))
