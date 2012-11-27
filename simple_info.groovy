import grisu.jcommons.model.info.*

none = Group.NO_VO_GROUP

testbed = new Site(
		name = 'Testbed'
		)

none_vo_fs = new FileSystem(
		host:'globus.test.nesi.org.nz',
		protocol:'gsiftp',
		port:2811,
		site:testbed
		)
none_vo_home = new Directory(
		filesystem:none_vo_fs,
		groups:[none],
		path:"/~/",
		shared:false,
		volatileDirectory:false
		)

java = new Application(name:'Java')
r = new Application(name:'R')
exe_java = Executable.get('java')
exe_javac = Executable.get('javac')
exe_r = Executable.get('R')

java15 = new Package(
		application:java,
		version: Version.get('1.5.0'),
		executables: [exe_java, exe_javac]
		)

r_2_15_1 = new Package(
		application:r,
		version:Version.get('2.15.1'),
		executables: [exe_r]
		)

gram52 = Middleware.get("Globus", "5.2");
testbed_gram52 = new Gateway(
		site:testbed,
		host:'globus.test.nesi.org.nz',
		middleware:gram52
		)

test1 = new Queue(
		gateway:testbed_gram52,
		name:'test1',
		groups:[none],
		directories:[none_vo_home],
		packages:[java15,r_2_15_1],
		walltimeInMinutes:10
		)

