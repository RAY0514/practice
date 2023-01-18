import {createRouter, createWebHistory} from 'vue-router'

import searchMember from './components/searchMember.vue'
import insertPage from './components/insertPage.vue'
import editPage from './components/editPage.vue'

const routers = [
    {
        path: '/',
        name: searchMember,
        component: searchMember
    },
    {
        path: '/insertPage',
        name: insertPage,
        component: insertPage,

    },
    {
        path: '/editPage',
        name: editPage,
        component: editPage,

    },
]

const router = createRouter({
    history: createWebHistory(),
    routes: routers,

});
export default router;
