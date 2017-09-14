SUMMARY = "Linaro test definitions and Runner"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=12f884d2ae1ff87c09e5b7ccc2c4ca7e"

SRCREV = "597e24cb6704f816cb655bf35c4acab1c40e2176"
PV = "0.1"

SRC_URI = "git://git.linaro.org/qa/test-definitions.git;protocol=https"

S = "${WORKDIR}/git"

do_install() {
        installbase=${D}/root
        installdir=${installbase}/test-definitions

        install -d -m0700 ${D}/root
	cp -r ${WORKDIR}/git ${installdir}

	# FIXME: there are binaries inside the test-definitions repo
	rm -r ${installdir}/automated/bin
	rm -r ${installdir}/automated/linux/cyclictest/bin
	rm -r ${installdir}/automated/linux/signaltest/bin
	rm -r ${installdir}/automated/linux/pmqtest/bin
	rm -r ${installdir}/automated/linux/rt-migrate-test/bin
	rm -r ${installdir}/automated/linux/pi-stress/bin
	rm -r ${installdir}/automated/linux/hackbench/bin
	rm -r ${installdir}/automated/linux/linpack/bin
	rm -r ${installdir}/automated/linux/blogbench/bin
	rm -r ${installdir}/automated/linux/lmbench/bin
	rm -r ${installdir}/automated/linux/stream/bin
}

FILES_${PN} = "/root/test-definitions"

inherit allarch 
