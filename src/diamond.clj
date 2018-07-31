(ns diamond
  (:require [clojure.string :as str]))

(defn- pad [n] (apply str (repeat n " ")))

(defn- make-row
  "Create a string for the `idx`th row, given the index of the widest
  point is `max-idx`"
  [idx max-idx]
  (let [letter (char (+ (int \A) idx))
        outer-pad (pad (- max-idx idx))
        inner-pad (pad (dec (* 2 idx)))]
    (if (zero? idx)
      (str outer-pad "A" outer-pad)
      (str outer-pad letter inner-pad letter outer-pad))))

(defn diamond
  "Return a list of strings, each string representing a row of a diamond.
  The diamond is composed of letters and spaces, with the letters forming
  the edges of the diamond.  The letters increase alphabetically from A to Z,
  then returning back to A once the diamond reaches its widest point,
  given by `c`.

  e.g. the Diamond for letter 'C', with spaces represented by '·':
  ··A··
  ·B·B·
  C···C
  ·B·B·
  ··A··"
  [c]
  (let [max-idx (- (int c) (int \A))
        top-half-idxs (range (inc max-idx))
        idxs (concat top-half-idxs (rest (reverse top-half-idxs)))]
    (map #(make-row %1 max-idx) idxs)))
