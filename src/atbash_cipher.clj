(ns atbash-cipher
    (:require [clojure.string :refer [join lower-case]]))

(def dict (zipmap "abcdefghijklmnopqrstuvwxyz0123456789"
                  "zyxwvutsrqponmlkjihgfedcba0123456789"))

(defn encode [s]
  (let [clump-size 5]
    (->> (lower-case s)
         (map dict)
         (filter identity)
         (partition-all clump-size)
         (map (partial apply str))
         (join " "))))
