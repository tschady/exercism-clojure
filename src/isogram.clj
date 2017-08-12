(ns isogram
  (:require [clojure.string :as str]))

(defn isogram?
  "Return true if input string `s` is an isogram, else false.
  (An isogram is a word or phrase without a repeating letter).
  Non-letter characters are not considered for isogram qualification."
  [s]
  (let [normal-str (filter #(Character/isLetter %) (str/lower-case s))]
    (= (count normal-str) (count (set normal-str)))))
