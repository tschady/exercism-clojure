(ns crypto-square
  (:require [clojure.string :refer [join lower-case]]))

(defn normalize-plaintext [s] (lower-case (join (re-seq #"\p{Alnum}" s))))

(defn square-size [s] (int (Math/ceil (Math/sqrt (count s)))))

(defn plaintext-segments [s]
  (let [nt (normalize-plaintext s)
        sz (square-size nt)]
    (map #(apply str %) (partition-all sz nt))))

(defn- cipher-seq [s]
  (let [nt (normalize-plaintext s)
        sz (square-size nt)]
    (->> (partition sz sz (repeat "") nt)
         (apply map #(apply str %&)))))

(defn normalize-ciphertext [s] (join " " (cipher-seq s)))

(defn ciphertext [s] (join (cipher-seq s)))
