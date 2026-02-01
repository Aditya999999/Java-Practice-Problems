from django.urls import path
from myapp.views import ItemListCreate, ItemRetrieveUpdateDestroy, ProtectedView, CustomTokenObtainPairView
from rest_framework_simplejwt.views import (
    TokenObtainPairView,
    TokenRefreshView,
)


urlpatterns = [
    path('protected/', ProtectedView.as_view(), name='protected_view'),
    path('login/', CustomTokenObtainPairView.as_view(), name='token_obtain_pair'),
    path('token/refresh/', TokenRefreshView.as_view(), name='token_refresh'),
    path('items/', ItemListCreate.as_view(), name='item-list-create'),
    path('items/<int:pk>/', ItemRetrieveUpdateDestroy.as_view(), name='item-detail'),
]
