all: r

r:
	@JAVA_TOOL_OPTIONS='-Dfile.encoding=UTF8' sbt run

run:
	@sbt mklauncher > /dev/null
	@sbt package-bin > /dev/null
	@./target/scala-sbt target/scala-2.10/sexp-l-calc-compiler_2.10-0.1-SNAPSHOT.jar

test:
	JAVA_TOOL_OPTIONS='-Dfile.encoding=UTF8' sbt test:run

answers:
	for i in tests/*.rkt; \
	do if [ ! -f $$i.expected ]; then \
	printf "%s\n" "Compiling $$i"; \
	racket compile.rkt < $$i > $$i.expected; \
	fi done
