all: run

run:
	JAVA_TOOL_OPTIONS='-Dfile.encoding=UTF8' sbt run

test:
	JAVA_TOOL_OPTIONS='-Dfile.encoding=UTF8' sbt test:run

answers:
	for i in tests/*.rkt; \
	do if [ ! -f $$i.expected ]; then \
	printf "%s\n" "Compiling $$i"; \
	racket compile.rkt < $$i > $$i.expected; \
	fi done
