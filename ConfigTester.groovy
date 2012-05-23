
import grisu.grin.YnfoManager
import grisu.grin.model.Grid

@GrabResolver(name='nesi-stable', root='http://code.ceres.auckland.ac.nz/nexus/content/groups/public/')
@GrabResolver(name='nesi-snapshot', root='http://code.ceres.auckland.ac.nz/nexus/content/groups/public-snapshots/')
@Grab(group='nz.nesi', module='grin', version='0.1-SNAPSHOT', changing=true)

class ConfigTester {

	static main(args) {

		if (args.length == 0 ) {
			println 'No url specified, using default testbed config...'
			args = [
				'https://raw.github.com/nesi/nesi-grid-info/develop/testbed.groovy'
			]
		}

		def url = args[0]
		println 'Using info config from: "'+url+'..."'
		def ym = new YnfoManager(url)

		Grid grid = ym.getGrid()

		println 'Sites:'
		for ( def site : grid.getSites() ) {
			println '\t'+site.toString()
			//			printConnections(site)
		}

		println 'VOs:'
		for ( def vo : grid.getVos() ) {
			println '\t'+vo.getVoName()
			//			printConnections(vo)
		}

		println 'Groups:'
		for ( def group : grid.getGroups() ) {
			println '\t' + group.getFqan()
			//			printConnections(group)
		}

		println 'Filesystems:'
		for ( def fs : grid.getFilesystems() ) {
			println '\t' + fs.getUrl()
			//			printConnections(fs)
		}

		println 'Directories:'
		for ( def dir : grid.getDirectorys() ) {
			println '\t' + dir.getUrl()
			//			printConnections(dir)
		}

		println 'Gateways:'
		for ( def gw : grid.getGateways() ) {
			println '\t' + gw.toString()
			//			printConnections(gw)
		}

		println 'Queues:'
		for ( def q : grid.getQueues() ) {
			println '\t' + q.toString()
			//			printConnections(q)
		}

		println 'Applications:'
		for ( def app : grid.getApplications() ) {
			println '\t' + app.getName()
			//			printConnections(app)
		}

		println 'Versions:'
		for ( def v : grid.getVersions() ) {
			println '\t' + v.getVersion()
			//			printConnections(v)
		}

		println 'Packages:'
		for ( def p : grid.getPackages() ) {
			println '\t' + p.getName()
			//			printConnections(p)
		}

		System.exit(0)
	}
}
