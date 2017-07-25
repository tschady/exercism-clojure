(ns binary)

;;; cheater way
(defn to-decimal [s]
  (try
    (Integer/parseInt s 2)
    (catch NumberFormatException _ 0)))

;;; spirit of the exercise way
(defn to-decimal [s]
  (->> (reverse s)
       (filter #(or (= \0 %1) (= \1 %1)))
       (map-indexed #(bit-shift-left (Character/digit %2 10) %1))
       (reduce + 0)))
