(ns clj-course.vetores)

(def precos [30 700 1000])

(println (precos 0))
; usando vetor como função
(println (get precos 0))
(println (get precos 2))
(println "valor padão nil"(get precos 17))
(println "valor padrão 0"(get precos 17 0)) ; se não existir devolve o valor 0
(println "valor padão 0, mas existe"(get precos 2 0))

(println (conj precos 5)) ; lembrando que o vetor original não foi alterado ele é imutável

(println precos)


(println (+ 5 1))
(println (inc 5)) ; increase

(println (update precos 0 inc)) ; extrair o vetor precos e acrecentar mais um no número da posição 0
(println (update precos 0 dec)) ; tirar um

(defn soma-1
  [valor]
  (println "estou comando um em" valor)
  (+ valor 1))

(println (update precos 0 soma-1))
