(ns anagram
  (:require [clojure.string :refer [lower-case]]))

(def alphagram (comp sort lower-case))

(defn anagram? [word candidate]
  (and (not= (lower-case word) (lower-case candidate))
       (= (alphagram word) (alphagram candidate))))

(defn anagrams-for [word candidates]
  (filter #(anagram? word %) candidates))
