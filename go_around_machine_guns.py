from battle import commander
unit_client = commander.Client()

def search_and_destroy(data=None, *args, **kawargs):
    center = unit_client.ask_center()
    unit_client.do_attack(center['id'])
    unit_client.when_item_destroyed(center['id'], search_and_destroy)

def go_to_corner2(*args, **kawargs):
    me = unit_client.ask_my_info()
    unit_client.do_move((21,39))
    unit_client.when_in_area((21,39), 2, search_and_destroy)

def go_to_corner1(*args, **kawargs):
    me = unit_client.ask_my_info()
    unit_client.do_move((39,39))
    unit_client.when_in_area((39,39), 2, go_to_corner2)
    

go_to_corner1()
