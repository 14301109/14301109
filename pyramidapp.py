from pyramid.config import Configurator
from pyramid.httpexceptions import  HTTPNotFound
from pyramid.response import Response


def hello_world(request):
    file_object=open('hello.html')
    try:
        all_the_text=file_object.read()
    finally:
        file_object.close();
    return Response(
        all_the_text,
        content_type='text/html',
    )
def random(request):
    url=request.path
    return Response(
        'Hello!\n'+url            
    )

config = Configurator()
config.add_route('hello', '/hello.html')

config.add_view(hello_world, route_name='hello')




app = config.make_wsgi_app()
