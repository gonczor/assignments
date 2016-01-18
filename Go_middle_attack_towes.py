from battle import commander
unit_client = commander.Client()

def search_and_destroy(data=None, *args, **kawargs):
    enemy = unit_client.ask_nearest_enemy()
    unit_client.do_attack(enemy['id'])
    unit_client.when_item_destroyed(enemy['id'], search_and_destroy)


def go_to_middle(*args, **kawargs):
    me = unit_client.ask_my_info()
    unit_client.do_move((39,20))
    unit_client.when_in_area((39,20), 1, search_and_destroy)
    

go_to_middle()