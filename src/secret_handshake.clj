(ns secret-handshake)

(def action->code {"wink"            2r000001
                   "double blink"    2r000010
                   "close your eyes" 2r000100
                   "jump"            2r001000})

(def reverse-code 2r010000)

(defn commands [n]
  (let [reverse-it? (pos? (bit-and n reverse-code))]
    (as-> action->code result
      (keep #(if (pos? (bit-and n (second %))) (first %)) result)
      (vec result)
      (if reverse-it?
        (reverse result)
        result))))
