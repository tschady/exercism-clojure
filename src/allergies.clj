(ns allergies)

(def allergy->score {:eggs          2r00000001
                     :peanuts       2r00000010
                     :shellfish     2r00000100
                     :strawberries  2r00001000
                     :tomatoes      2r00010000
                     :chocolate     2r00100000
                     :pollen        2r01000000
                     :cats          2r10000000})

(defn allergies
  "Return vector of allergen keywords indicated by the score.
  A score is a decimal sum of binary bitmap values of allergies."
  [score]
  (->> allergy->score
       (keep #(if (pos? (bit-and score (second %))) (first %)))
       vec))

(defn allergic-to?
  "Predicate function indicating if allergy score `score` represents an allergy to keyword `k`"
  [score k]
  (some? (some #{k} (allergies score))))
