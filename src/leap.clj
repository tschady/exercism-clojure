(ns leap)

(defn leap-year?
  "Predicate function for whether given year is a leap year."
  [year]
  (or (zero? (mod year 400))
      (and (zero? (mod year 4))
           (not (zero? (mod year 100))))))
