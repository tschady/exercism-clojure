(ns acronym
  (:require [clojure.string :as str]))

(defn acronym
  "Generate acronym from text by concatenating first letter of each word.
  '-' is considered a word boundary. (e.g. 'a b-c d' -> 'ABCD')"
  [s]
  (->> (str/split s #"[\W-]")
       (map first)
       (apply str)
       (str/upper-case)))
