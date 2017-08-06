(ns rotational-cipher)

(defn- rotate-char-around-base
  "Shift character `c` by `n` around base `base-char`."
  [base-char c n]
  (let [base-val (int base-char)]
    (-> c
        int
        (- base-val)
        (+ n)
        (mod 26)
        (+ base-val)
        char)))

(defn- rotate-alpha-char
  "Shift char `c` value by `n`, wrapping to A if past Z.
  If `c` is not an alpha character, pass it through."
  [c n]
  (cond
    (not (Character/isLetter c)) c
    (Character/isUpperCase c) (rotate-char-around-base \A c n)
    (Character/isLowerCase c) (rotate-char-around-base \a c n)))

(defn rotate
  "Apply rotational cipher to input string `s`, shifting by `n` letters.
  Non alpha-characters and whitespace are not affected.  (Also known as the
  Caeser cipher, whose most famous form is `ROT13`)."
  [s n]
  (->> (seq s)
       (map #(rotate-alpha-char % n))
       (apply str)))
