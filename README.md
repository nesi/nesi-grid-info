This repository contains info config files that describe the current nesi grid and nesi testbed grid setup.

## Testing config syntax

You'll need a fairly recent version of Groovy to run this (in the root of the project):

    groovy ConfigTester.groovy <url_or_path_to_config>
	
If you specify an url, the tester will download the config file. For local testing you'll most likely specify a path. There are also 2 aliases, for convenience:

 - testbed : downloads the current 'mater' version for the testbed config from https://github.com/nesi/nesi-grid-info
 - nesi : downloads the current 'mater' version for the nesi config from https://github.com/nesi/nesi-grid-info

Because of some Groovy/Grape issues, if you want to run this script against a new version of the Grin library, you might need to delete all *-SNAPSHOT versions from your local $HOME/.groovy/grape repository every now and then (so Grape re-downloads updated dependencies)
