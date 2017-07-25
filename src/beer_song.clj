(ns beer-song
  (:require [clojure.pprint :refer [cl-format]]
            [clojure.string :refer [join]]))

;;; No, I don't think this is good code!
;;;  My goal was semi-readable golfing
(defn verse [count]
  (let [next-count (if (zero? count) 99 (dec count))]
    (cl-format nil "~[No more~:;~:*~D~] bottle~:P of beer on the wall, ~
                    ~:*~[no more~:;~:*~D~] bottle~:P of beer.~%~
                    ~:*~[Go to the store and buy some more~:;Take ~:*~[~;it~:;one~] down and pass it around~], ~
                    ~[no more~:;~:*~D~] bottle~:P of beer on the wall.~%"
               count next-count)))

(defn sing
  ([from] (sing from 0))
  ([from to] (join "\n" (map verse (range from (dec to) -1)))))
