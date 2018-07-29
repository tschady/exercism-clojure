(ns say
  (:require [clojure.pprint :as pp]
            [clojure.string :as str]))

(defn number
  "Spell out the given number in English."
  [n]
  {:pre [(or (< -1 n 1000000000000)
             (throw (IllegalArgumentException.)))] }
  (-> (pp/cl-format nil "~r" n)
      (str/replace #"," "")))
