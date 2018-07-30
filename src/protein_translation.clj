(ns protein-translation
  (:require [clojure.string :as str]))

(def ^:private codon->protein {"AUG" "Methionine"
                               "UUU" "Phenylalanine"
                               "UUC" "Phenylalanine"
                               "UUA" "Leucine"
                               "UUG" "Leucine"
                               "UCU" "Serine"
                               "UCC" "Serine"
                               "UCA" "Serine"
                               "UCG" "Serine"
                               "UAU" "Tyrosine"
                               "UAC" "Tyrosine"
                               "UGU" "Cysteine"
                               "UGC" "Cysteine"
                               "UGG" "Tryptophan"
                               "UAA" "STOP"
                               "UAG" "STOP"
                               "UGA" "STOP"})

(defn translate-codon
  "Return amino acid built by this codon, or 'STOP' if stop codon."
  [codon]
  (codon->protein codon))

(defn translate-rna
  "Return protein sequence encoded by given rna, until STOP codon."
  [rna]
  (let [codons (map str/join (partition-all 3 rna))]
    (take-while #(not= "STOP" %) (map translate-codon codons))))
