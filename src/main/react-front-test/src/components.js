const createElement = domString => {
  const $temp = document.createElement('template');
  $temp.innerHTML = domString;
  return $temp.content;
};

const fetchData = async url => {
  const res = await fetch(url);
  return res.json();
};

export const Home = async () => {
  const { content } = await fetchData('/api/hello');
  return createElement(`<p>${content}</p>`);
};

export const NotFound = () => createElement('<h1>404 NotFound</p>');