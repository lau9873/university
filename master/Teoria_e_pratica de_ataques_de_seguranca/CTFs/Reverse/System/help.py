from angr import *

# https://s0uthwood.github.io/post/angr-ctf-writeup/
proj = Project('./system', load_options={'auto_load_libs': False}, main_opts={'base_addr':0x00100000})
state = proj.factory.entry_state()
simgr = proj.factory.simgr(state)
find_addr = 0x00400976 # win addr
simgr.explore(find = find_addr)

if simgr.found:
    simulations = simgr.found[0]
    print (simulations.posix.dumps(0))
else:
    print ('no result') 
