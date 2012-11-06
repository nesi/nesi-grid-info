import grisu.jcommons.model.info.*
import grisu.model.info.dto.Application
import grisu.model.info.dto.Directory
import grisu.model.info.dto.Executable
import grisu.model.info.dto.Gateway
import grisu.model.info.dto.Middleware
import grisu.model.info.dto.Site
import grisu.model.info.dto.VO



// sites

testbed = new Site(
		name = 'Testbed'
		)

// vos
test = new VO(
		voName = 'test',
		host = 'voms.test.bestgrid.org',
		port = 15000,
		hostDN = '/C=nz/O=org/O=nesi/OU=test/OU=local/CN=voms.test.bestgrid.org'
		)

// groups
none = Group.NO_VO_GROUP

nesi = new Group(
		vo = test,
		fqan = "/test/nesi"
		)

// groups
demo = new Group(
		vo = test,
		fqan = "/test/demo"
		)

// filesystems
akl_fs = new FileSystem(
		host:'globus.test.nesi.org.nz',
		protocol:'gsiftp',
		port:2811,
		site:testbed
		)

df = new FileSystem(
		host:'irods-dev.ceres.auckland.ac.nz',
		protocol:'gsiftp',
		port:2811,
		site:testbed
		)


// directories
akl_home = new Directory(
		filesystem:akl_fs,
		groups:[nesi, demo, none],
		path:"/~/",
		shared:false,
		volatileDirectory:false)

df_home = new Directory(
		filesystem:df,
		groups:[none],
		path:"/~/",
		shared:false,
		volatileDirectory:false)

gram52 = Middleware.get("Globus", "5.2");

// gateways
testbed_gram52 = new Gateway(
		site:testbed_info,
		host:'globus.test.nesi.org.nz',
		middleware:gram52
		)

// applications
java = new Application(
		name:'Java'
		)

python = new Application(
		name:'Python'
		)

r = new Application(
		name:'R'
		)

unixcommands = new Application(
		name:'UnixCommands'
		)

// executables
exe_java = Executable.get('java')
exe_javac = Executable.get('javac')
exe_python = Executable.get('python')
exe_cat = Executable.get('cat')
exe_ls = Executable.get('ls')
exe_diff = Executable.get('diff')
exe_echo = Executable.get('echo')
exe_sh = Executable.get('sh')
exe_r = Executable.get('R')

// packages
unixcommands_01 = new Package(
		application:unixcommands,
		version: Version.get('0.1'),
		executables: [exe_cat, exe_ls, exe_diff, exe_echo, exe_sh]
		)
java15 = new Package(
		application:java,
		version: Version.get('1.5.0'),
		executables: [exe_java, exe_javac]
		)


python26 = new Package(
		application:python,
		version:Version.get('2.6'),
		executables: [exe_python]
		)

r_2_15_1 = new Package(
		application:r,
		version:Version.get('2.15.1'),
		executables: [exe_r]
		)

// updaters
defaultUpdater = new DefaultQueueUpdater()

// queues
batch = new Queue(
		gateway:testbed_gram52,
		name:'batch',
		groups:[nesi,demo],
		directories:[akl_home],
		packages:[java15,python26,unixcommands_01,r_2_15_1],
		updater:defaultUpdater
		)

test1 = new Queue(
		gateway:testbed_gram52,
		name:'test1',
		groups:[nesi, none],
		directories:[akl_home],
		packages:[java15,r_2_15_1],
		updater:defaultUpdater,
		walltimeInMinutes:10
		)

