// Input Language:
// <exp> ::= <var>
//
//        |  #t
//        |  #f
//        |  (if  <exp> <exp> <exp>)
//        |  (and <exp> <exp>)
//        |  (or  <exp> <exp>)
//
//        |  <nat>
//        |  (zero? <exp>)
//        |  (- <exp> <exp>)
//        |  (= <exp> <exp>)
//        |  (+ <exp> <exp>)
//        |  (* <exp> <exp>)
//
//        |  <lam>
//        |  (let ((<var> <exp>) ...) <exp>)
//        |  (letrec ((<var> <lam>)) <exp>)
//
//        |  (cons <exp> <exp>)
//        |  (car  <exp>)
//        |  (cdr  <exp>)
//        |  (pair? <exp>)
//        |  (null? <exp>)
//        |  (quote ())
//
//        |  (<exp> <exp> ...)
//
// <lam> ::= (λ (<var> ...) <exp>)
//
// Output Language:
// <exp> ::= <var>
//        |  (<exp> <exp>)
//        |  (λ (<var>) <exp>)

object Compile {
  def apply(in: Exp): String = {
    in match {
      case _ => in.toString
    }
  }
}
