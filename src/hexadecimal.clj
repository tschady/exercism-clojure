(ns hexadecimal)

(defn hex-to-int [s]
  (try
    (Integer/parseInt s 16)
    (catch NumberFormatException _ 0)))
