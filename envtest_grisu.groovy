import nz.org.nesi.envtester.*

def config = [:]

config.put('execute', 'true')

config.put('host', 'pan.nesi.org.nz')
config.put('name', 'traceroute test auckland')
traceroute1 = new TraceRouteTest(config)

config.put('port', '5001')
config.put('name', 'iperf test auckland')
iperf1 = new IPerfTest(config)

config.put('host', 'ucgridserver.canterbury.ac.nz')
config.put('name', 'traceroute test canterbury')
traceroute2 = new TraceRouteTest(config)

config.put('port', '40000')
config.put('name', 'iperf test canterbury')
iperf2 = new IPerfTest(config)




